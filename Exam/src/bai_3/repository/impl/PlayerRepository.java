package bai_3.repository.impl;

import bai_3.data.ReadAndWrite;
import bai_3.model.Player;
import bai_3.repository.IPlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository implements IPlayerRepository {
    private static List<Player> playerList = new ArrayList<>();
//    public Player(String playerCode, String playerName, String birthDay, String address, String teamName) {

    static {
        playerList.add(new Player("CT-001","Duy","10/02/1999","Quang Nam","QNK Quang Nam"));
    }
    private final String PLAYER_PATH = "src/bai_3/data/player.csv";
    @Override
    public List<Player> getAll() {
        List<String> strings = ReadAndWrite.readFile(PLAYER_PATH);
        playerList.clear();

        String[] info;
        for (String str:strings) {
            info = str.split(",");
            playerList.add(new Player(info[0],info[1],info[2],info[3],info[4]));
        }
        return playerList;
    }
}
