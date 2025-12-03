package edu.uoc.locuocomotive.controller;

import edu.uoc.locuocomotive.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class LocUOComotiveController {

    private List<Station> stations;
    private List<Route> routes;
    private List<Train> trains;
    private List<Ticket> tickets;
    private Map<String, Passenger> passengers;
    private Station currentStation;

    public LocUOComotiveController(String stationsFile, String routesFile, String trainsFile) {
        stations = new ArrayList<>();
        routes = new ArrayList<>();
        trains = new ArrayList<>();
        tickets = new ArrayList<>();
        passengers = new HashMap<>();

        loadStations(stationsFile);
        loadTrains(trainsFile);
        loadRoutes(routesFile);

        if (!stations.isEmpty()) {
            currentStation = stations.get(0);
        }
    }

    private void loadStations(String stationsFile) {
        InputStream is = getClass().getResourceAsStream("/data/" + stationsFile);

        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + stationsFile);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                addStation(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRoutes(String routesFile) {
        InputStream is = getClass().getResourceAsStream("/data/" + routesFile);

        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + routesFile);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                String[] parts2 = parts[0].split("\\|");

                addRoute(parts2[0], Integer.parseInt(parts2[1]), parts[1].split("\\|"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTrains(String trainsFile) {
        InputStream is = getClass().getResourceAsStream("/data/" + trainsFile);

        if (is == null) {
            throw new NullPointerException("Cannot find resource file " + trainsFile);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                int[] seatsPerCar = new int[parts.length - 2];

                for (int i = 2; i < parts.length; i++) {
                    seatsPerCar[i - 2] = Integer.parseInt(parts[i]);
                }

                addTrain(Integer.parseInt(parts[0]), parts[1], seatsPerCar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStation(int id, String name, String city, int openingYear, String type, String image, int positionX, int positionY) {
        StationType stationType = StationType.valueOf(type.toUpperCase());
        Station station = new Station(String.valueOf(id), name, city, openingYear, stationType, positionX, positionY, image);
        stations.add(station);
    }

    public void addRoute(String id, int trainId, String... stationsAndTimes) {
        List<Station> routeStations = new ArrayList<>();
        List<Schedule> schedules = new ArrayList<>();
        Train train = null;

        for (Train t : trains) {
            if (t.getId().equals(String.valueOf(trainId))) {
                train = t;
                break;
            }
        }

        if (train == null) {
            throw new IllegalArgumentException("Train with id " + trainId + " not found.");
        }

        int startStationId = Integer.parseInt(stationsAndTimes[0].split("\\[")[0]);
        int endStationId = Integer.parseInt(stationsAndTimes[stationsAndTimes.length - 1].split("\\[")[0]);

        for (String stationAndTime : stationsAndTimes) {
            String[] parts = stationAndTime.split("\\[");
            if (parts.length < 2) {
                throw new IllegalArgumentException("Invalid station and time format: " + stationAndTime);
            }

            int stationId = Integer.parseInt(parts[0]);
            String[] times = parts[1].replace("]", "").split(",");
            if (times.length < 2) {
                throw new IllegalArgumentException("Invalid times format: " + parts[1]);
            }

            LocalTime departureTime = LocalTime.parse(times[0].trim());
            LocalTime arrivalTime = LocalTime.parse(times[1].trim());
            int travelTime = (int) java.time.Duration.between(departureTime, arrivalTime).toMinutes(); // calcular el tiempo de viaje en minutos

            for (Station station : stations) {
                if (Integer.parseInt(station.getId()) == stationId) {
                    routeStations.add(station);
                    schedules.add(new Schedule(stationId, departureTime, arrivalTime, travelTime, startStationId, endStationId));
                    break;
                }
            }
        }

        Route route = new Route(id, train, routeStations, schedules);
        routes.add(route);
    }




    public void addTrain(int id, String model, int... cars) {
        List<Car> carList = new ArrayList<>();
        int carNumber = 1;

        for (int carSeats : cars) {
            String carId = "C" + carNumber;
            if (carSeats == 0) {
                carList.add(new RestaurantCar(carId));
            } else if (carSeats < 20) {
                carList.add(new PassengerCar(carId, SeatClass.FIRST_CLASS, carSeats));
            } else if (carSeats < 50) {
                carList.add(new PassengerCar(carId, SeatClass.SECOND_CLASS, carSeats));
            } else {
                carList.add(new PassengerCar(carId, SeatClass.THIRD_CLASS, carSeats));
            }
            carNumber++;
        }

        Train train = new Train(String.valueOf(id), model, carList);
        trains.add(train);
    }

    public List<String> getStationsInfo() {
        List<String> stationInfo = new ArrayList<>();
        for (Station station : stations) {
            stationInfo.add(station.toString());
        }
        return stationInfo;
    }

    public String[] getSeatTypes() {
        return Arrays.stream(SeatClass.values()).map(Enum::name).toArray(String[]::new);
    }

    public List<String> getRoutesByStation(int stationId) {
        List<String> result = new ArrayList<>();
        for (Route route : routes) {
            for (int i = 0; i < route.getStations().size(); i++) {
                Station station = route.getStations().get(i);
                if (Integer.parseInt(station.getId()) == stationId) {
                    Schedule schedule = route.getSchedules().get(i);
                    String departureTime = schedule.getDepartureTime().toString();
                    String arrivalTime = schedule.getArrivalTime().toString();
                    int travelTime = schedule.getTravelTime();
                    Station startStation = stations.stream().filter(s -> s.getId().equals(String.valueOf(schedule.getStartStationId()))).findFirst().orElse(null);
                    Station endStation = stations.stream().filter(s -> s.getId().equals(String.valueOf(schedule.getEndStationId()))).findFirst().orElse(null);

                    if (startStation != null && endStation != null) {
                        result.add(departureTime + "-" + arrivalTime + "|" + route.getId() + "|" + travelTime + "|" + station.getId() + "|" + startStation.getId() + "|" + startStation.getName() + "|" + startStation.getCity());
                    }
                }
            }
        }
        return result;
    }




    public void addPassenger(String passport, String name, String surname, LocalDate birthdate, String email) throws Exception {
        if (passport == null || passport.isEmpty() || name == null || name.isEmpty() || surname == null || surname.isEmpty() || birthdate == null) {
            throw new IllegalArgumentException("Invalid passenger details");
        }
        if (email != null && !email.isEmpty()) {
            if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,3}")) {
                throw new IllegalArgumentException("Invalid email format");
            }
        }

        Passenger passenger = new Passenger(passport, name, surname, birthdate, email);
        passengers.put(passport, passenger);
    }

    public void createTicket(String passport, String routeId, LocalTime departureTime, LocalTime arrivalTime, double cost, int originStationId, int destinationStationId, String selectedSeatType) throws Exception {
        Passenger passenger = passengers.get(passport);
        if (passenger == null) {
            throw new Exception("Passenger not found");
        }

        Route route = null;
        for (Route r : routes) {
            if (r.getId().equals(routeId)) {
                route = r;
                break;
            }
        }
        if (route == null) {
            throw new Exception("Route not found");
        }
        if (route.getTrain() == null) {
            throw new Exception("Train not found for the route");
        }

        String seatReference = null;
        for (Car car : route.getTrain().getCars()) {
            if (car instanceof PassengerCar && ((PassengerCar) car).getSeatClass().name().equals(selectedSeatType)) {
                seatReference = car.getId() + "-1";
                break;
            }
        }
        if (seatReference == null) {
            throw new Exception("No available seat found for the selected seat type");
        }

        String originStationName = null;
        String destinationStationName = null;
        for (Station station : route.getStations()) {
            if (station.getId().equals(String.valueOf(originStationId))) {
                originStationName = station.getName();
            }
            if (station.getId().equals(String.valueOf(destinationStationId))) {
                destinationStationName = station.getName();
            }
        }
        if (originStationName == null || destinationStationName == null) {
            throw new Exception("Invalid station IDs");
        }

        Ticket ticket = new Ticket(passenger, seatReference, cost, originStationName, destinationStationName, departureTime.toString(), arrivalTime.toString());
        ticket.setRouteId(routeId);
        tickets.add(ticket);
    }

    public void buyTicket(String passport, String name, String surname, LocalDate birthdate, String email, String routeId, LocalTime departureTime, LocalTime arrivalTime, double cost, int originStationId, int destinationStationId, String selectedSeatType) throws Exception {
        addPassenger(passport, name, surname, birthdate, email);
        createTicket(passport, routeId, departureTime, arrivalTime, cost, originStationId, destinationStationId, selectedSeatType);

        for (Station station : stations) {
            if (Integer.parseInt(station.getId()) == destinationStationId) {
                currentStation = station;
                break;
            }
        }
    }

    public List<String> getAllTickets() {
        List<String> result = new ArrayList<>();
        for (Ticket ticket : tickets) {
            result.add(ticket.getRouteId() + "|" + ticket.getDepartureTime() + "|" + ticket.getDepartureStation() + "|" + ticket.getArrivalTime() + "|" + ticket.getArrivalStation() + "|" + ticket.getSeatReference() + "|" + ticket.getPrice());
        }
        return result;
    }

    public String getPassengerInfo(String passport) {
        Passenger passenger = passengers.get(passport);
        if (passenger == null) {
            return "";
        }
        return passenger.getPassport() + "|" + passenger.getName() + "|" + passenger.getSurname() + "|" + passenger.getBirthDate() + "|" + passenger.getEmail();
    }

    public String getTrainInfo(int trainId) {
        for (Train train : trains) {
            if (train.getId().equals(String.valueOf(trainId))) {
                return train.getId() + "|" + train.getModel() + "|" + train.getCars().size();
            }
        }
        return "";
    }

    public List<String> getPassengerTickets(String passport) {
        List<String> result = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getPassenger().getPassport().equals(passport)) {
                result.add(ticket.getRouteId() + "|" + ticket.getDepartureTime() + "|" + ticket.getDepartureStation() + "|" + ticket.getArrivalTime() + "|" + ticket.getArrivalStation() + "|" + ticket.getSeatReference() + "|" + ticket.getPrice());
            }
        }
        return result;
    }

    public List<String> getRouteDeparturesInfo(String routeId) {
        List<String> result = new ArrayList<>();
        for (Route route : routes) {
            if (route.getId().equals(routeId)) {
                for (Schedule schedule : route.getSchedules()) {
                    result.add(schedule.getStationId() + "|[" + schedule.getDepartureTime() + ", " + schedule.getArrivalTime() + "]");
                }
            }
        }
        return result;
    }

    public int getCurrentStationId() {
        return Integer.parseInt(currentStation.getId());
    }
}
