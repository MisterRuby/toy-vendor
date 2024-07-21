package ruby.moduleapi

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ruby.modulecore.exception.CommonException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CommonException::class)
    fun handleCommonException(e: CommonException): ResponseEntity<ExceptionResponse> {
        return ResponseEntity(ExceptionResponse(e.message), HttpStatus.valueOf(e.status))
    }
}

data class ExceptionResponse(val message: String)