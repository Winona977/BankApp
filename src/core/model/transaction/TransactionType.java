/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model.transaction;

import core.controller.utils.Response;

/**
 *
 * @author scues
 */
public interface TransactionType extends Nameable {
    public Response doTransaction(Transaction t);
}
