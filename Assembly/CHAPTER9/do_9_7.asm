.MODEL	SMALL
.STACK	100H
.DATA
ArrayB	DB	7 DUP (?)
.CODE
MAIN	PROC
;7개의 요소의 바이트 배열 ArrayB 입력 -> 최대값 출력하는 프로그램
	MOV	AX,@DATA
	MOV	DS,AX
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	XOR	SI,SI			;변위를 SI로 사용한다, 0으로 초기화
	CALL	INDECM	
	MOV	ArrayB[SI],AL		;ArrayB[0] 에 첫 숫자인 AL을 저장한다
	MOV	BL,AL			;합산 : BL
	MOV	CX,6			;값은 7개 이지만, 비교가 6번이기 때문

@IN_TOP:
	INC	SI			;다음 변위로 이동
	CALL	INDECM
	MOV	ArrayB[SI],AL		;다음 숫자를 배열의 다음위치에 저장한다
	CMP	AL,BL			;저장되어 있는 BL과 새로들어온 AL 값을 비교한다

	JLE	@NEXT			;AL이 작거나 같은경우 -> 다음숫자로 패스
	MOV	BL,AL			;AL이 큰 경우 -> BL 값으로 넣는다

@NEXT:
	LOOP	@IN_TOP			;6번 반복 끝날때까지 반복한다

	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H

	MOV	AL,BL			;핪 BL -> 출력을 위해 AL 이동
	CBW				;AL -> AX로 확장
	CALL	OUTDECM

	MOV	AH,4CH
	INT	21H

MAIN	ENDP

INCLUDE	INDECM.ASM
INCLUDE	OUTDECM.ASM

	END	MAIN