package pl.arek.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arek.controller.dto.*;
import pl.arek.exception.InvalidGameException;
import pl.arek.exception.InvalidParamsException;
import pl.arek.model.Game;
import pl.arek.model.GamePlay;
import pl.arek.model.Player;
import pl.arek.service.GameService;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {
 
    private final GameService gameService;
    private final SimpMessagingTemplate simpMessagingTemplate;
    
    @PostMapping("/start")
    public ResponseEntity<Game> start(@RequestBody Player player){
        log.info("Start game request: {}", player);
        return ResponseEntity.ok(gameService.createGame(player));
    }
    
    @PostMapping("/connect")
    public ResponseEntity<Game> connect(@RequestBody ConnectRequest request) throws InvalidParamsException, InvalidGameException{
        log.info("Connecting game request: {}", request);
        return ResponseEntity.ok(gameService.connectToGame(request.getPlayer(), request.getGameId()));
    }
    
    @PostMapping("/connect/random")
    public ResponseEntity<Game> connectRandom(@RequestBody Player player) throws InvalidGameException{
        log.info("Connecting random game request: {}", player);
        return ResponseEntity.ok(gameService.connectToRndomGame(player));
    }
    
    @PostMapping("/play")
    public ResponseEntity<Game> play(@RequestBody GamePlay request) throws InvalidGameException{
        log.info("Play: {}", request);
        Game game = gameService.gamePlay(request);
        simpMessagingTemplate.convertAndSend("/topic/game-progress/"+game.getGameId(), game);
        return ResponseEntity.ok(game);
    }
    
    @GetMapping("/author")
    public String getAuthor(){
        return "Game made by Arek";
    }
}
