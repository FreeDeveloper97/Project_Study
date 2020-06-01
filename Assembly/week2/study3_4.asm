.MODEL SMALL
.STACK 100H
.DATA
IN_MSG		DB	'Input Character: $'
OUT_MSG		DB	0DH,0AH,'Output Character: '
CharData		DB	?,'$'

.CODE
MAIN	PROC
	MOV	AX,@DATA
	MOV	DS,AX

	MOV	AH,9		;문자열 출력 명령어
	LEA	DX,IN_MSG	;문자열 주소 저장
	INT	21H		;문자열 출력

	MOV	AH,1		;한문자 입력 명령어
	INT	21H		;한문자 입력
	MOV	CharData,AL	;입력한 문자, CharData에 저장

	MOV	AH,9		;문자열 출력 명령어
	LEA	DX,OUT_MSG	;문자열 주소 저장
	INT	21H		;문자열 출력

	MOV	AH,4CH		;종료 명령어
	INT	21H		;종료
MAIN	ENDP
	END	MAIN	