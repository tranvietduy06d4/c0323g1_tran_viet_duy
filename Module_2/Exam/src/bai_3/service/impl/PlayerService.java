package bai_3.service.impl;

import bai_3.model.Player;
import bai_3.repository.IPlayerRepository;
import bai_3.repository.impl.PlayerRepository;
import bai_3.service.IPlayerService;

import java.util.List;
import java.util.Scanner;

public class PlayerService implements IPlayerService {
    private Scanner scanner = new Scanner(System.in);
    private IPlayerRepository playerRepository = new PlayerRepository();
    @Override
    public void getAll() {
        List<Player> playerList = playerRepository.getAll();
        for (Player p:playerList) {
            System.out.println(p);
        }
    }
}
