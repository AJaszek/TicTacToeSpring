/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.arek.controller.dto;

import lombok.Data;
import pl.arek.model.Player;

/**
 *
 * @author Arek
 */
@Data
public class ConnectRequest {
    
    private Player player;
    private String gameId;
}
