package com.ps;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ContractFileManager {

    public static void saveContract(Contract contract){

        try(BufferedWriter writer = new BufferedWriter((new FileWriter("contracts.txt", true)))){
            if (contract instanceof SalesContract){
                SalesContract salesContract = (SalesContract) contract;
                writer.write(
                        "SALE|" +
                                salesContract.getDateOfContract() + "|" +
                                salesContract.getCustomerName() + "|" +
                                salesContract.getCustomerEmail() + "|" +
                                salesContract.getVehicleSold() + "|" +
                                salesContract.getSalesTaxAmount() + "|" +
                                salesContract.getTotalPrice() + "|" +
                                (salesContract.isFinance() ? "YES" : "NO") + "|" +
                                salesContract.getMonthlyPayment() + "\n"
                );
            } else if (contract instanceof LeaseContract){
                LeaseContract leaseContract = (LeaseContract) contract;
                writer.write(
                        "LEASE|" +
                                leaseContract.getDateOfContract() + "|" +
                                leaseContract.getCustomerName() + "|" +
                                leaseContract.getCustomerEmail() + "|" +
                                leaseContract.getVehicleSold() + "|" +
                                leaseContract.getExpectedEndingValue() + "|" +
                                leaseContract.getLeaseFee() + "|" +
                                leaseContract.getTotalPrice() +
                                leaseContract.getMonthlyPayment() + "\n"
                );
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
