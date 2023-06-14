package bai_3.model;

public class Player {
    private String playerCode;
    private String playerName;
    private String birthDay;
    private String address;
    private String teamName;

    public Player() {
    }

    public Player(String playerCode, String playerName, String birthDay, String address, String teamName) {
        this.playerCode = playerCode;
        this.playerName = playerName;
        this.birthDay = birthDay;
        this.address = address;
        this.teamName = teamName;
    }

    public String getPlayerCode() {
        return playerCode;
    }

    public void setPlayerCode(String playerCode) {
        this.playerCode = playerCode;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return  "Mã cầu thủ: " + playerCode + '\'' +
                ", Tên cầu thủ: " + playerName + '\'' +
                ", Ngày sinh: " + birthDay + '\'' +
                ", Địa chỉ: " + address + '\'' +
                ", Tên đội bóng: " + teamName + '\'';
    }
}
