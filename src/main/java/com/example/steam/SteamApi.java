package com.example.steam;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SteamApi {
    final String API_KEY = "";
    private final SteamApiService steamApiService;
    @GetMapping()
    public void GetPlayerSummaries(){
        steamApiService.getSummary(this.API_KEY);
    }
    @GetMapping("play")
    public void getRecentlyPlayedGames(){
        steamApiService.getRecentlyPlayedGames(this.API_KEY, "76561198151225041", 10);
    }

}
