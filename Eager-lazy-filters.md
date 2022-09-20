## Eager filter 

Listeler Iterator ile opere edilir. Iterator ona zincirlenen her operasyonun yapıldığından emin olur. Ve işlemlerin tamamını bitirdikten sonra diğer operasyona geçer. 

```
val list = listOf(1, 2, 3, 4, 5, 6)
val result = list
        .map{ println("In Map"); it * 2 }
        .filter { println("In Filter");it % 3  == 0 }
println("Before Average")
println(result.average())
```

![1_DZiZXY-bSTYx7QkpkcY8mg](https://user-images.githubusercontent.com/78302281/188330551-a16dc067-42ab-45e7-af34-180856e236e9.png)

Yukardaki örnekte görüleceği üzere, önce bütün map işlemleri yapılır. Listenin içindeki her elemana mapte belirtilen operasyon uygulanır. Daha sonra filterdan geçer ve listedeki her eleman filtera sokulduktan sonra  .average() çağrılır. Yani bütün işlemler belirtilen sırayla yapılır ve bir önceki işlem bitmeden sonrakine geçilmez.
Buna eager filtre denir.

Lazy Filter (Sequance) 

![1_LQmASXbh3qwOg2ag0Dh9RQ](https://user-images.githubusercontent.com/78302281/188330558-9a367b10-706f-46dc-86af-24b5fc7471a7.png)

Yukardaki koda asSequance() ekleyerek List ‘ i Sequance ‘ a çevirelim. 
```
val list = listOf(1, 2, 3, 4, 5, 6)
val result = list.asSequence()
        .map{ println("In Map"); it * 2 }
        .filter { println("In Filter");it % 3  == 0 }
println("Before Average")
println(result.average())
```

Yukardaki kod bloğundan önce “In map” , “In map” …  yazdırmasını daha sonra “In Filter” ,  “In Filter” … sonrasında “Before average” sonrasında listenin son halinin ortalama değerini yazdırmasını bekleriz. Ama öyle çalışmaz. Yukardan aşağıya satırları işleyen derleyici val result satırına geldiğinde bunun artık List değil Sequance olduğunu fark eder ve buna bir Terminal bağlanmadığı sürece burdaki kodu çalıştırmaz ve bu satırı atlar. İlk olarak “Before average” yazdırır. Sonrasında “result.average()” satırına geldiğinde artık result değişkenine bir Terminal bağlandığını görür ve hemen “val result”  satırına geri döner işlemleri yapmaya başlar. Bu aşamada bir farklılık daha var burda List’ten farklı olarak Sequance her iterasyonda 1 zincir tamamlayacak şekilde çalışır. 0. İndekste map(1 * 2) ->  filter( 2 % 3 == 0) -> map(2*2) -> filter(4 % 3) -> map (3 * 2) -> filter( 6 % 3 == 0) burda artık result değişkenin “.first” elemanı var olduğu için - 6 - ve result değişkenin başka bir şeyine ihtiyacımız olmadığı için işlemi durdurur. 

Bunun şöyle bir avantajı vardır:

Aynı işlemi asSequance kullanmadan yapınca 13 operasyon, asSequance kullanınca 7 operasyon yapmış oluruz.
