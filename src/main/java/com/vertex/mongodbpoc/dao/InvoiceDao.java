package com.vertex.mongodbpoc.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.vertex.mongodbpoc.config.ApplicationProperties;
import com.vertex.mongodbpoc.dto.InvoiceDTO;
import com.vertex.mongodbpoc.exception.AppException;
import com.vertex.mongodbpoc.util.TransformerUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InvoiceDao {
    private final @NonNull MongoClient mongoClient;
    private final @NonNull ApplicationProperties properties;
    private final @NonNull @Qualifier("mongopocDb") MongoDatabase database;
    private final @NonNull @Qualifier("invoiceCollection") MongoCollection<Document> collection;


    public void createInvoice(InvoiceDTO invoiceDTO) throws AppException {
        try {
            log.info("Executing InvoiceDao.createInvoice for inserting the invoice in the database: {}", invoiceDTO);
            collection.insertOne(TransformerUtil.mapTo(invoiceDTO));
        } catch (Exception ex) {
            log.error("Error Executing InvoiceDao.createInvoice : {0}", ex);
            throw new AppException("Error Executing InvoiceDao.createInvoice : " + ex.getMessage());
        } finally {
            log.info("Exiting InvoiceDao.createInvoice after inserted the invoice in the database");
        }
    }
    public InvoiceDTO getInvoiceById(String invoiceId) throws AppException {
        try {
            log.info("Executing InvoiceDao.getInvoiceById fetching the invoice from the database: {}", invoiceId);

            Document query = new Document("ID", new Document("$eq", invoiceId));
            List<InvoiceDTO> invoiceDTOS = new ArrayList<>();
            collection.find(query).iterator().forEachRemaining(doc -> {
                String id = doc.get("ID", String.class);
                invoiceDTOS.add(TransformerUtil.mapTo(id, doc));
            });
            return invoiceDTOS.stream()
                    .findFirst()
                    .orElse(null);
        } catch (Exception ex) {
            log.error("Error Executing InvoiceDao.getInvoiceById : {0}", ex);
            throw new AppException("Error Executing InvoiceDao.getInvoiceById");
        } finally {
            log.info("Exiting InvoiceDao.getInvoiceById after fetching the invoice from the database");
        }
    }

    public List<InvoiceDTO> getAllInvoices() throws AppException {
        try {
            log.info("Executing InvoiceDao.getAllInvoices for fetching all the invoice in the database");
            List<InvoiceDTO> invoiceDTOS = new ArrayList<>();
            collection.find().iterator().forEachRemaining(doc -> {
                String id = doc.get("ID", String.class);
                invoiceDTOS.add(TransformerUtil.mapTo(id, doc));
            });
            return invoiceDTOS;
        } catch (Exception ex) {
            log.error("Error Executing InvoiceDao.getAllInvoices : {0}", ex);
            throw new AppException("Error Executing InvoiceDao.getAllInvoices");
        } finally {
            log.info("Exiting InvoiceDao.getAllInvoices after fetching all the invoice in the database");
        }
    }

    public void updateInvoice(InvoiceDTO invoiceDTO) throws AppException {
        try {
            log.info("Executing InvoiceDao.updateInvoice for updating the invoice in the database: {}", invoiceDTO);
            Document query = new Document("ID", new Document("$eq", invoiceDTO.getId()));

            Document update = new Document("$set", TransformerUtil.mapToFields(invoiceDTO));
            collection.updateOne(query, update);
        } catch (Exception ex) {
            log.error("Error Executing InvoiceDao.updateInvoice : {0}", ex);
            throw new AppException("Error Executing InvoiceDao.updateInvoice");
        } finally {
            log.info("Exiting InvoiceDao.updateInvoice after updating the invoice in the database");
        }
    }

    public void deleteInvoice(String invoiceId) throws AppException {
        try {
            log.info("Executing InvoiceDao.deleteInvoice deleting the invoice in the database: {}", invoiceId);
            Document query = new Document("ID", new Document("$eq", invoiceId));
            collection.deleteMany(query);
        } catch (Exception ex) {
            log.error("Error Executing InvoiceDao.deleteInvoice : {0}", ex);
            throw new AppException("Error Executing InvoiceDao.deleteInvoice");
        } finally {
            log.info("Exiting InvoiceDao.deleteInvoice after deleting the invoice in the database");
        }
    }

}
