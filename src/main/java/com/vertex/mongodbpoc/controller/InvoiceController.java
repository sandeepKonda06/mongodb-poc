package com.vertex.mongodbpoc.controller;

import com.vertex.mongodbpoc.exception.AppException;
import com.vertex.mongodbpoc.service.InvoiceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vertex.mongodbpoc.dto.InvoiceDTO;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/invoice")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InvoiceController {
    private final @NonNull InvoiceService invoiceService;

    @GetMapping(path = "/id", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public InvoiceDTO getInvoiceById(@RequestParam(name = "invoiceId") String invoiceId) throws AppException {
        try {
            log.info("Executing InvoiceController.getInvoiceById for fetching invoice id : {}", invoiceId);
            return invoiceService.getInvoiceById(invoiceId);
        } finally {
            log.info("Exiting InvoiceController.getInvoiceById after fetching invoice");
        }
    }

    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices() throws AppException {
        try {
            log.info("Executing InvoiceController.getAllInvoices fetching all invoices");
            return ResponseEntity.ok(invoiceService.getAllInvoices());
        } finally {
            log.info("Exiting InvoiceController.getAllInvoices after fetching all invoices");
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoiceDTO) throws AppException {
        try {
            log.info("Executing InvoiceController.createInvoice creating the invoice: {}", invoiceDTO);
            return ResponseEntity.ok(invoiceService.createInvoice(invoiceDTO));
        } finally {
            log.info("Exiting InvoiceController.createInvoice after invoice creation");
        }
    }

    @PatchMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<InvoiceDTO> updateInvoice(@RequestBody InvoiceDTO invoiceDTO) throws AppException {
        try {
            log.info("Executing InvoiceController.updateInvoice updateInvoice all invoices");
            return ResponseEntity.ok(invoiceService.updateInvoice(invoiceDTO));
        } finally {
            log.info("Exiting InvoiceController.updateInvoice after updateInvoice");
        }
    }

    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteInvoice(@NonNull @RequestParam(name = "invoiceId") String invoiceId ) throws AppException {
        try {
            log.info("Executing InvoiceController.deleteInvoice deleteInvoice");
            invoiceService.deleteInvoice(invoiceId);
            return ResponseEntity.ok("Successfully Deleted invoiceId : " + invoiceId);
        } finally {
            log.info("Exiting InvoiceController.deleteInvoice after deleteInvoice");
        }
    }

}
