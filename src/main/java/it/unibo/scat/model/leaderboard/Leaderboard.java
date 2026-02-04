package it.unibo.scat.model.leaderboard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.unibo.scat.common.GameRecord;

/**
 * This class handles the leaderboard logic.
 */
public class Leaderboard {
    private final List<GameRecord> games;
    private final String leaderboardFile; // CORREGGERLO

    /**
     * Leaderboard constructor.
     * 
     * @param filename the name of the file containing the leaderboard records
     * 
     */
    public Leaderboard(final String filename) {
        this.leaderboardFile = filename;
        games = new ArrayList<>();
    }

    /**
     * Initializes the leaderboard.
     * 
     */
    public void initLeaderboard() {
        final int idxName = 0;
        final int idxScore = 1;
        final int idxLevel = 2;
        final int idxDate = 3;
        final Path pathLeaderboard = Path.of(leaderboardFile);
        try {

            final Path parent = pathLeaderboard.getParent();
            if (parent != null && !Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            if (!Files.exists(pathLeaderboard)) {
                Files.createFile(pathLeaderboard);
            }
        } catch (final Exception e) {
            throw new IllegalStateException("Cannot create leaderboard file: " + leaderboardFile + " Exception: ", e);
        }

        try (BufferedReader reader = Files.newBufferedReader(pathLeaderboard, StandardCharsets.UTF_8)) {
            String line;
            String name;
            int score;
            int level;
            LocalDate date;
            line = reader.readLine();
            while (line != null) {
                final String[] field = line.trim().split(";");

                name = String.valueOf(field[idxName]);
                score = Integer.parseInt(field[idxScore]);
                level = Integer.parseInt(field[idxLevel]);
                date = LocalDate.parse(field[idxDate].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                games.add(new GameRecord(name, score, level, date));

                line = reader.readLine();

            }

        } catch (final IOException e) {
            throw new IllegalStateException("Cannot load records from file: " + leaderboardFile + "Exception: ", e);
        }
        sortGames();
    }

    /**
     * Completely rewrites the leaderboard file with the current sorted records.
     */
    public void updateFile() {
        sortGames();
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(leaderboardFile))) {
            for (final GameRecord game : games) {
                writer.write(
                        game.getName() + ";" + game.getScore() + ";" + game.getLevel() + ";" + game.getDate() + "\n");
            }
        } catch (final IOException e) {
            throw new IllegalStateException("Cannot write leaderboard on file: " + leaderboardFile + "Exsception: ", e);
        }

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(leaderboardFile), StandardCharsets.UTF_8))) {

            for (final GameRecord g : games) {
                writer.write(g.getName() + ";");
                writer.write(g.getScore() + ";");
                writer.write(g.getLevel() + ";");
                writer.write(g.getDate() + ";");
                writer.newLine();
            }

        } catch (final IOException e) {
            throw new IllegalStateException("Cannot write records into file: " + leaderboardFile + "Exception: ", e);
        }

    }

    /**
     * adds a new record to the leaderboard and updates the file.
     * 
     * @param newRecord the record to add
     */
    public void addNewGameRecord(final GameRecord newRecord) {
        games.add(newRecord);
        updateFile();
    }

    /**
     * @return all the records of the leaderboard.
     * 
     */
    public List<GameRecord> getAllRecords() {
        return List.copyOf(games);
    }

    /**
     * Sorts the game records by score, then by level, then by date.
     */
    public void sortGames() {
        games.sort(new Comparator<>() {

            @Override
            public int compare(final GameRecord o1, final GameRecord o2) {
                int r = Integer.compare(o2.getScore(), o1.getScore());
                if (r != 0) {
                    return r;
                }
                r = Integer.compare(o2.getLevel(), o1.getLevel());
                if (r != 0) {
                    return r;
                }
                r = o1.getDate().compareTo(o2.getDate());
                if (r != 0) {
                    return r;
                }
                return 0;
            }

        });

    }

}
