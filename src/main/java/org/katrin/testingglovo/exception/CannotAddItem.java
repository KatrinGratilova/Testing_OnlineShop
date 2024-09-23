package org.katrin.testingglovo.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CannotAddItem extends RuntimeException {
    private String message;
}
