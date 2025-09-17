package com.waihon.designpatterns.mosh.template;

public class GenerateReportTask {
    private AuditTrail auditTrail;

    public GenerateReportTask() {
        this.auditTrail = new AuditTrail();
    }

    public void execute() {
        auditTrail.record();

        System.out.println("Generate Report");
    }
}
