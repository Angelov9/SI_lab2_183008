# Втора лабораториска вежба по Софтверско инженерство

## Филип Ангелов, бр. на индеџ 183008

## Група на код: 2

## Control Flow Graph
![](CFG.png)

## Циколматска комплексонст 
Цикломатската комплексност на овој Control Flow Graph е 8, истат е добиена 
преку трите формули:
R = 8
E - N + 2 = 28 - 22 + 2 = 8
P + 1 = 7 + 1 = 8
## Тест случаи според критериумот Every path и Every branch
1. user = null, allUsers = new List()
2. user = (null, null,  null), allUsers = new List()
3. user = (Filip, null,  null), allUsers = new List()
4. user = (Filip, null,  emy.c), allUsers = new List()
5. user = (Filip, null,  em@yc), allUsers = new List()
6. user = (Filip, null,  em2@y.c), allUsers = new List()

## Објаснување на напишаните unit test
