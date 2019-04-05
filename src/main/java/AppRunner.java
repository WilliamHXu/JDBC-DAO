import daos.ConnectionFactory;
import daos.Player;
import daos.PlayerDAO;

import java.sql.Connection;
import java.util.List;

public class AppRunner {


    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();

        PlayerDAO playerDAO = new PlayerDAO(connection);

        List<Player> playerList = playerDAO.findAll();

        for (Player player: playerList) {
            System.out.println(player.toString());
        }

        System.out.println("-----------------------------------------------------------");

        Player will = new Player(11, "Will", "USA", 24, 500, 1);

        playerDAO.create(will);

        System.out.println(playerDAO.findByID(11).toString());

        System.out.println("-----------------------------------------------------------");

        will.setPoints(1000);
        will.setTourn_played(2);
        playerDAO.update(will);

        System.out.println(playerDAO.findByID(11).toString());

        System.out.println("-----------------------------------------------------------");

        playerList = playerDAO.findAll();

        for (Player player: playerList) {
            System.out.println(player.toString());
        }

        System.out.println("-----------------------------------------------------------");

        playerDAO.delete(11);
    }

}
