package com.tcs.gerate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "EVMSC";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        try {
            Long sequenceNumber = getNextSequenceNumber(session);
            return PREFIX + String.format("%03d", sequenceNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error generating user ID", e);
        }
    }

    private Long getNextSequenceNumber(SharedSessionContractImplementor session) {
        return session.doReturningWork(connection -> {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO userid_sequence_table VALUES (null)", PreparedStatement.RETURN_GENERATED_KEYS)) {
                preparedStatement.executeUpdate();

                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        return resultSet.getLong(1);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Unable to retrieve the sequence number", e);
            }
            throw new RuntimeException("Unable to retrieve the sequence number");
        });
    }
}
