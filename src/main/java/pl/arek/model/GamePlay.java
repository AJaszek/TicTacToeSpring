/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.arek.model;

import lombok.Data;

/**
 *
 * @author Arek
 */
@Data
public class GamePlay {
    private TicToe type;
    private Integer x;
    private Integer y;
    private String gameId;
}
