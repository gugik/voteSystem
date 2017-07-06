package vote_system;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDate date) {
        return (date == null ? null : Timestamp.valueOf(date.atStartOfDay()));
    }

    @Override
    public LocalDate convertToEntityAttribute(Timestamp sqlTimestamp) {
        return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime().toLocalDate());
    }


}