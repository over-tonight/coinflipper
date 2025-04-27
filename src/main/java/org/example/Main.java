package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.SecureRandom;
import java.awt.*;
import java.util.*;

public class Main {
    public static String whoWins(String creator, String opponent) throws IOException {
        SecureRandom random = new SecureRandom();
        random.setSeed(System.nanoTime() + UUID.fromString("6981e65b-f3f9-48cd-ac5f-573f755b02bd").hashCode() + UUID.fromString("1e91563e-885f-4e99-932a-423076ff4d18").hashCode()); // Nanotime : Creator : Opponent
        ArrayList<String> players = new ArrayList<>(Arrays.asList(creator, opponent));
        Collections.shuffle(players, random);
        return players.get(random.nextInt(players.size()));
    }

    public static void gui() {
        Frame f = new Frame();
        Button b1 = new Button("COINFLIP");
        b1.setBounds(200, 200, 100, 50);
        f.add(b1);
        Label l1 = new Label("");
        l1.setBounds(235, 100, 200, 50);
        f.add(l1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    l1.setText(whoWins("ONE", "TWO"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        gui();
    }
}