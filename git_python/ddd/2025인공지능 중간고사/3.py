ch = "네"
m = 0
while ch == "네":
    cgm = int(input("환전할 금액을 입력하세요:"))
    cgm = cgm/1500
    m = m + cgm
    print("환전한 금액은 "+str(cgm)+" 입니다.")
    ch = input("다시하시겠습니까?")

print("총 환전한 유로화는"+str(m))