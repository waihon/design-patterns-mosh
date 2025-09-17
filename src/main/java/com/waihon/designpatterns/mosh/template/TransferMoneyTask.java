package com.waihon.designpatterns.mosh.template;

public class TransferMoneyTask {
    private AuditTrail auditTrail;

    public TransferMoneyTask() {
        this.auditTrail = new AuditTrail();
    }

    public void execute() {
        auditTrail.record();

        System.out.println("Transfer Money");
    }
}
