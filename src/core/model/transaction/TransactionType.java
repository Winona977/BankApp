/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model.transaction;

/**
 *
 * @author scues
 */
public interface TransactionType extends Nameable {
    public boolean doTransaction(Transaction t);
}
