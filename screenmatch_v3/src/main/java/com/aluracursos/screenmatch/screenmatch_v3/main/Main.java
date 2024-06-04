package com.aluracursos.screenmatch.screenmatch_v3.main;

import com.aluracursos.screenmatch.screenmatch_v3.model.DataShow;
import com.aluracursos.screenmatch.screenmatch_v3.model.SeasonData;
import com.aluracursos.screenmatch.screenmatch_v3.model.Show;
import com.aluracursos.screenmatch.screenmatch_v3.service.APIConsumption;
import com.aluracursos.screenmatch.screenmatch_v3.service.DataConversor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private Scanner keyboard = new Scanner(System.in);
    private APIConsumption apiConsumption = new APIConsumption();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=d7daaab3&";
    private DataConversor dataConversor = new DataConversor();
    private List<DataShow> dataShowList = new ArrayList<>();

    public void showMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Find Show
                    2 - Find Episodes
                    3 - Show searched series
                    
                    0 - Exit
                    """;
            System.out.println(menu);
            option = keyboard.nextInt();
            keyboard.nextLine();

            switch (option) {
                case 1:
                    searchShow();
                    break ;
                case 2:
                    findEpisodeByShow();
                    break ;
                case 3:
                    showSearchedSerie();
                    break ;
                case 0:
                    System.out.println("Closing the app...");
                    break ;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private DataShow getDataShow() {
        System.out.println("Write the name of the show you'd like: ");
        String showName = keyboard.nextLine();
        var json = apiConsumption.getData(URL_BASE + showName.replace(" ", "+") + API_KEY);
        System.out.println(json);
        DataShow dataShow = dataConversor.getData(json, DataShow.class);
        return dataShow;
    }

    private void findEpisodeByShow() {
        DataShow dataShow = getDataShow();
        List<SeasonData> seasonDataList = new ArrayList<>();

        for (int i = 1; i <= dataShow.totalSeasons(); i++) {
            var json = apiConsumption.getData(URL_BASE + dataShow.title().replace(" ", "+") +
                    "&Season=" + i + API_KEY);
            SeasonData seasonData = dataConversor.getData(json, SeasonData.class);
            seasonDataList.add(seasonData);
        }
        seasonDataList.forEach(System.out::println);
    }

    private void searchShow() {
        DataShow dataShow = getDataShow();
        dataShowList.add(dataShow);
        System.out.println(dataShow);
    }

    private void showSearchedSerie() {
        List<Show> showsList = new ArrayList<>();
        showsList = dataShowList.stream()
                .map(dataShow -> new Show(dataShow))
                .collect(Collectors.toList());
        showsList.stream()
                .sorted(Comparator.comparing(Show::getGenre))
                .forEach(System.out::println);
    }
}
