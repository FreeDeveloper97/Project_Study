.MODEL	SMALL
.STACK	100H
.DATA
	NO	DB	'NONE$'
.CODE
MAIN	PROC

	MOV	AX,@DATA
	MOV	DS,AX

	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	AH,1
	INT	21H
	MOV	BH,AL

	INT	21H
	MOV	BL,AL

	INT	21H
	MOV	CH,AL

	INT	21H
	MOV	CL,AL

	INT	21H
	MOV	DH,AL

	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H

	MOV	SP,0

	CMP	BH,'A'
	JB	@NEXT1
	CMP	BH,'Z'
	JA	@NEXT1
	MOV	DL,BH
	INT	21H
	MOV	SP,1
@NEXT1:
	CMP	BL,'A'
	JB	@NEXT2
	CMP	BL,'Z'
	JA	@NEXT2
	MOV	DL,BL
	INT	21H
	MOV	SP,1
@NEXT2:
	CMP	CH,'A'
	JB	@NEXT3
	CMP	CH,'Z'
	JA	@NEXT3
	MOV	DL,CH
	INT	21H
	MOV	SP,1
@NEXT3:
	CMP	CL,'A'
	JB	@NEXT4
	CMP	CL,'Z'
	JA	@NEXT4
	MOV	DL,CL
	INT	21H
	MOV	SP,1
@NEXT4:
	CMP	DH,'A'
	JB	@END
	CMP	DH,'Z'
	JA	@END
	MOV	DL,DH
	INT	21H
	MOV	SP,1
@END:
	CMP	SP,1
	JE	@EEND
	MOV	AH,9
	LEA	DX,NO
	INT	21H
@EEND:
	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN	