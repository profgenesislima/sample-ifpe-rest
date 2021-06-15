package br.edu.ifpe.gus.ads4arq.infra.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.edu.ifpe.gus.ads4arq.infra.validacao.dto.ErroRequisicaoDTO;

@RestControllerAdvice
public class ValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroRequisicaoDTO> validaDadosRequisicao(MethodArgumentNotValidException exception) {
		List<ErroRequisicaoDTO> erroRequisicaoDTO = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.stream().forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale()); 
			ErroRequisicaoDTO err = new ErroRequisicaoDTO(e.getField(), mensagem);
			erroRequisicaoDTO.add(err);
		});

		return erroRequisicaoDTO;
	}

}