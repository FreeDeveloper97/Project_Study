.MODEL	SMALL
.STACK	100H
.DATA
ERR_MSG		DB	'ERRPR$'
.CODE
MAIN	PROC
	MOV	AX,@DATA
	MOV	DS,AX

	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	AH,1
	INT	21H
	MOV	BL,AL

	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H

	CMP	BL,'A'		;A보다 커야한다
	JL	@ERROR		;작으면 error

	CMP	BL,'Z'		;Z보다 작거나 같아야 한다
	JLE	@UP_CAP	;작거나 같으면 대문자 통과

	CMP	BL,'a'		;a보다 커야한다
	JL	@ERROR		;작으면 error
	
	CMP	BL,'z'		;z보다 작거나 같아야 한다
	JLE	@LO_CAP	;작거나 같으면 소문자 통과

	JMP	@ERROR		;다 해상안되면 ERROR

@UP_CAP:
	ADD	BL,20H		;대문자+20H = 소문자
	MOV	DL,BL
	INT	21H

	JMP	@END_CASE

@LO_CAP:
	SUB	BL,20H		;소문자 - 20H = 대문자
	MOV	DL,BL
	INT	21H

	JMP	@END_CASE

@ERROR:
	MOV	AH,9		;문장출력
	LEA	DX,ERR_MSG	;DX에 LEA
	INT	21H

@END_CASE:
	MOV	AH,4CH
	INT	21H

MAIN	ENDP
	END	MAIN
