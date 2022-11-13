package assignment.lab6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;
    private LocalDateTime dateTime;
    @Column(length = 4000)
    private String exceptionType;
    @Column(length = 4000)
    private String operation;

    @ManyToOne
    private User principle;
}
