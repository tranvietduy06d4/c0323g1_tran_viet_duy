package service.impl;

import model.Facility.Facility;
import model.Facility.House;
import model.Facility.Room;
import model.Facility.Villa;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;
import utils.Regex;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();
    private Scanner scanner = new Scanner(System.in);

    private String nameRegex = "^(([A-Z][a-z]*)(\\s|$))+$";
    private String villaCodeRegex = "^(SVVL-)\\d{4}$";
    private String houseCodeRegex = "^(SVHO-)\\d{4}$";
    private String roomCodeRegex = "^(SVRO-)\\d{4}$";


    @Override
    public void displayAll() {
        Map<Facility, Integer> facilityMap = facilityRepository.getAll();
        Set<Facility> facilitySet = facilityMap.keySet();
        for (Facility f : facilitySet) {
            System.out.println(f + " , Time of use: " + facilityMap.get(f));
        }


    }

    @Override
    public void addNew() {
        ADD_FACILITY:
        do {
            System.out.println("Please choose service to add: \n" +
                    "Press 1. Add new Villa\n" +
                    "Press 2. Add new House\n" +
                    "Press 3. Add new Room\n" +
                    "Press 4. Return main menu\n");
            int addChoice = 0;
            try {
                addChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }

            if (addChoice >= 1 && addChoice <= 4) {
                switch (addChoice) {
                    case 1:
                        Facility villa = createNewVilla();
                        facilityRepository.addNew(villa);
                        System.out.println("Success. Finish add new villa");
                        break;
                    case 2:
                        Facility house = createNewHouse();
                        facilityRepository.addNew(house);
                        System.out.println("Success. Finish add new house");
                        break;
                    case 3:
                        Facility room = createNewRoom();
                        facilityRepository.addNew(room);
                        System.out.println("Success. Finish add new room");
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Wrong. Please try again");
                }
            }

        } while (true);


    }

    @Override
    public void delete() {
        String facilityCode;
        while (true) {
            System.out.println("Please enter facility code to delete: ");
            facilityCode = scanner.nextLine();

            Facility facility = facilityRepository.getByCode(facilityCode);

            if(facility != null) {
                facilityRepository.deleteFacility(facility);
                System.out.println("Success. Finish delete facility");
                break;
            }
            System.out.println("Wrong. This facility code is not available in our system");
        }



    }

//    public Room(String serviceCode, String serviceName, int serviceArea, int serviceFee, int maximumPerson, String rentType, String freeAdditionService) {

    private Facility createNewRoom() {

        String roomCode;

        while (true) {
            System.out.println("Please enter room code to add: ");
            roomCode = scanner.nextLine();
            if (facilityRepository.getByCode(roomCode) == null && Regex.checkCode(roomCode, roomCodeRegex)) {
                break;
            }
        }


        String roomName;
        do {
            System.out.println("Please enter name of room: ");
            roomName = scanner.nextLine();
        } while (!Regex.checkName(roomName, nameRegex));


        int roomArea;
        while (true) {
            System.out.println("Please enter area of room: ");
            try {
                roomArea = Integer.parseInt(scanner.nextLine());
                if(roomArea > 30) {
                    break;
                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }
        }


        int roomFee;
        while (true) {
            System.out.println("Please enter room fee: ");
            try {
                roomFee = Integer.parseInt(scanner.nextLine());
                if(roomFee > 0) {
                    break;
                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }
        }


        int maximumPerson;
        while (true) {
            System.out.println("Please enter maximum amount of person: ");
            try {
                maximumPerson = Integer.parseInt(scanner.nextLine());
                if(maximumPerson > 0 && maximumPerson < 20) {
                    break;
                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }
        }

        int rentChoice = 0;
        String renType = "";

        RENT_CHOICE:
        do {
            System.out.println("Please choose rent type: \n" +
                    "Press 1. Rent by year\n" +
                    "Press 2. Rent by month\n" +
                    "Press 3. Rent by day\n" +
                    "Press 4. Rent by hour\n" +
                    "Press 5. Back to main menu");
            try {
                rentChoice = Integer.parseInt(scanner.nextLine());
                switch (rentChoice) {
                    case 1:
                        renType = "Year";
                        break;
                    case 2:
                        renType = "Month";
                        break;
                    case 3:
                        renType = "Day";
                        break;
                    case 4:
                        renType = "Hour";
                        break;
                    case 5:
                        break RENT_CHOICE;
                    default:
                        System.out.println("Wrong number. Please try again");
                }

            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number. Please try again");
            }

        } while (true);


        String freeAdditionService;
        System.out.println("Please enter free additional service: ");
        freeAdditionService = scanner.nextLine();

        Facility newRoom = new Room(roomCode, roomName, roomArea, roomFee, maximumPerson, renType, freeAdditionService);
        return newRoom;
    }


//    public House(String serviceCode, String serviceName, int serviceArea, int serviceFee, int maximumPerson, String rentType, String houseStandard, int houseFloorQuantity) {

    public Facility createNewHouse() {

        String houseCode;

        while (true) {
            System.out.println("Please enter house code to add: ");
            houseCode = scanner.nextLine();
            if (facilityRepository.getByCode(houseCode) == null) {
                break;
            }
        }


        String houseName;
        do {
            System.out.println("Please enter name of house: ");
            houseName = scanner.nextLine();
        } while (!Regex.checkName(houseName, nameRegex));


        int houseArea;
        while (true) {
            System.out.println("Please enter area of house: ");
            try {
                houseArea = Integer.parseInt(scanner.nextLine());
                if(houseArea > 30) {
                    break;

                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }
        }


        int houseFee;
        while (true) {
            System.out.println("Please enter house fee: ");
            try {
                houseFee = Integer.parseInt(scanner.nextLine());
                if(houseFee > 0) {
                    break;

                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }
        }


        int maximumPerson;
        while (true) {
            System.out.println("Please enter maximum amount of person: ");
            try {
                maximumPerson = Integer.parseInt(scanner.nextLine());
                if(maximumPerson > 0 && maximumPerson <20) {
                    break;

                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }
        }


        int rentChoice = 0;
        String renType = "";

        RENT_CHOICE:
        do {
            System.out.println("Please choose rent type: \n" +
                    "Press 1. Rent by year\n" +
                    "Press 2. Rent by month\n" +
                    "Press 3. Rent by day\n" +
                    "Press 4. Rent by hour\n" +
                    "Press 5. Back to main menu");
            try {
                rentChoice = Integer.parseInt(scanner.nextLine());
                switch (rentChoice) {
                    case 1:
                        renType = "Year";
                        break;
                    case 2:
                        renType = "Month";
                        break;
                    case 3:
                        renType = "Day";
                        break;
                    case 4:
                        renType = "Hour";
                        break;
                    case 5:
                        break RENT_CHOICE;
                    default:
                        System.out.println("Wrong number. Please try again");
                }

            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number. Please try again");
            }
        } while (true);


        String houseStandard;
        do {
            System.out.println("Please enter house standard: ");
            houseStandard = scanner.nextLine();
        } while (!Regex.checkName(houseStandard, nameRegex));


        int floorQuantity;
        do {
            System.out.println("Please enter quantity of floor: ");
            try {
                floorQuantity = Integer.parseInt(scanner.nextLine());
                if(floorQuantity >=1) {
                    break;

                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number. Please try again");
            }
        } while (true);


        Facility newHouse = new House(houseCode, houseName, houseArea, houseFee, maximumPerson, renType, houseStandard, floorQuantity);
        return newHouse;
    }

    public Facility createNewVilla() {
        String villaCode;

        while (true) {
            System.out.println("Please enter villa code to add: ");
            villaCode = scanner.nextLine();
            if (facilityRepository.getByCode(villaCode) == null && Regex.checkCode(villaCode, villaCodeRegex)) {
                break;
            }
        }


        String villaName;
        do {
            System.out.println("Please enter name of villa: ");
            villaName = scanner.nextLine();
        } while (!Regex.checkName(villaName, nameRegex));


        int villaArea;
        while (true) {
            System.out.println("Please enter area of villa: ");
            try {
                villaArea = Integer.parseInt(scanner.nextLine());
                if (villaArea > 30) {
                    break;

                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }
        }


        int villaFee;
        while (true) {
            System.out.println("Please enter villa fee: ");
            try {
                villaFee = Integer.parseInt(scanner.nextLine());
                if (villaFee > 0) {
                    break;

                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }
        }


        int maximumPerson;
        while (true) {
            System.out.println("Please enter maximum amount of person: ");
            try {
                maximumPerson = Integer.parseInt(scanner.nextLine());
                if (maximumPerson >0 && maximumPerson <20 ) {
                    break;

                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }
        }

        int rentChoice = 0;
        String renType = "";

        RENT_CHOICE:
        do {
            System.out.println("Please choose rent type: \n" +
                    "Press 1. Rent by year\n" +
                    "Press 2. Rent by month\n" +
                    "Press 3. Rent by day\n" +
                    "Press 4. Rent by hour\n" +
                    "Press 5. Back to main menu");
            try {
                rentChoice = Integer.parseInt(scanner.nextLine());
                switch (rentChoice) {
                    case 1:
                        renType = "Year";
                        break RENT_CHOICE;
                    case 2:
                        renType = "Month";
                        break RENT_CHOICE;
                    case 3:
                        renType = "Day";
                        break RENT_CHOICE;
                    case 4:
                        renType = "Hour";
                        break RENT_CHOICE;
                    case 5:
                        break RENT_CHOICE;
                    default:
                        System.out.println("Wrong number. Please try again");
                }

            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number. Please try again");
            }
        } while (true);


        String villaStandard;
        do {
            System.out.println("Please enter villa standard: ");
            villaStandard = scanner.nextLine();
        } while (!Regex.checkName(villaStandard, nameRegex));


        int poolArea;
        while (true) {
            System.out.println("Please enter swimming pool area: ");
            try {
                poolArea = Integer.parseInt(scanner.nextLine());
                if (poolArea >30) {
                    break;

                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number");
            }
        }


        int floorQuantity;
        do {
            System.out.println("Please enter quantity of floor: ");
            try {
                floorQuantity = Integer.parseInt(scanner.nextLine());
                if (floorQuantity >=1) {
                    break;

                }
            } catch (NumberFormatException n) {
                System.out.println("Wrong. It is not a number. Please try again");
            }
        } while (true);

//    public Villa(String serviceCode, String serviceName, int serviceArea, int serviceFee, int maximumPerson, String rentType, String villaStandard, int poolArea, int villaFloorQuantity) {


        Facility newVilla = new Villa(villaCode, villaName, villaArea, villaFee, maximumPerson, renType, villaStandard, poolArea, floorQuantity);

        return newVilla;

    }

    @Override
    public void displayListFacilityMaintenance() {
        Map<Facility,Integer> maintenanceFacilityList = facilityRepository.getAll();
        for (Facility facility:maintenanceFacilityList.keySet()) {
            if (maintenanceFacilityList.get(facility)>=5){
                System.out.println(facility);
            }
        }
    }
}
