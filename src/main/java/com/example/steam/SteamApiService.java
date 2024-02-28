package com.example.steam;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SteamApiService {
    public void getSummary(String apiKey){
        WebClient webClient = WebClient.builder().build();
        String url ="https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=" +apiKey +"&steamids=76561197960435530";
        String response = webClient.get()
                .uri(url)
                .header("x-test", "header")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(response);
    }

    public void getRecentlyPlayedGames(String apiKey, String steamId, int count){
        WebClient webClient = WebClient.builder().build();
        String url ="https://api.steampowered.com/IPlayerService/GetRecentlyPlayedGames/v1/?key=" + apiKey + "&steamid=" + steamId + "&count=" + count;
        String response = webClient.get()
                .uri(url)
                .header("x-test", "header")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println(response);
    }
}
