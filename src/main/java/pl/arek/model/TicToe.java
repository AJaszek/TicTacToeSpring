/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pl.arek.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Arek
 */
@AllArgsConstructor
@Getter
public enum TicToe {
    X(1), O(2);
    
    private int value;
}
