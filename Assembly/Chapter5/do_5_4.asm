.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
@START:
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	AH,1
	INT	21H
	MOV	BL,AL

	CMP	BL,'a'
	JB	@ERROR
	CMP	BL,'z'
	JA	@ERROR

	INT	21H
	MOV	BH,AL

	CMP	BH,'a'
	JB	@ERROR
	CMP	BH,'z'
	JA	@ERROR

	CMP	BL,BH
	JBE	@PRT
	XCHG	BL,BH
	JMP	@PRT
@ERROR:
	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H
	JMP	@START
@PRT:
	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H
	MOV	DL,BL
	INT	21H
	MOV	DL,BH
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN