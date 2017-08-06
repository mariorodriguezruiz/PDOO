#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'prize.rb'
require_relative 'monster.rb'
require_relative 'bad_consequence.rb'
require_relative 'treasure_kind.rb'

class PruebaNapakalaki
  
  monsters = Array.new
  
  #// ----------- MONSTRUOS ----------- \\
  
  #El rey de la rosa
  price = Prize.new(4,2)
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 tesoros visibles',5 , 3, 0)
  monsters << Monster.new('El rey de rosa', 13, badConsequence, price)
  
  #Ángeles de la noche ibicenca
  price = Prize.new(4,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta', 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
  monsters << Monster.new('Angeles de la noche ibicenca', 14, badConsequence, price)
  
  #3 Byakhees de bonanza
  price = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible y otra oculta', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
  monsters << Monster.new('3 Byakhees de bonanza', 8, badConsequence, price)
  
  #Chibithulhu
  badConsequence = BadConsequence.newLevelSpecificTreasures('Embobados con el lindo primigenio te descartas de tu casco visible', 0,[TreasureKind::ARMOR],Array.new)
  price = Prize.new(1,1)
  monsters << Monster.new('Chibithulhu', 2, badConsequence, price);
  
  #El sopor de Dunwich
  badConsequence = BadConsequence.newLevelSpecificTreasures('El primordial bostezo contagioso. Pierdes el calzado visible', 0, [TreasureKind::ARMOR], Array.new)
  price = Prize.new(1,1)
  monsters << Monster.new('El sopor de Dunwich', 2, badConsequence, price)
  
  #El gorron en elumbral
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles.", 0, 999, 0)
  price = Prize.new(3,1)
  monsters << Monster.new("El gorron en el umbral", 10, badConsequence, price)
  
  #H.P. Munchcraft
  badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible.", 0,[TreasureKind::ARMOR], Array.new)
  price = Prize.new(2,1)
  monsters << Monster.new("H.P. Munchcraft", 6, badConsequence, price)
  
  #Bichgooth
  badConsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, [TreasureKind::ARMOR], Array.new)
  price = Prize.new(1,1)
  monsters << Monster.new("Bichgooth", 2, badConsequence, price)
  
  #La que redacta en las tinieblas
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible.", 2, 0, 0)
  price = Prize.new(1,1)
  monsters << Monster.new("La que redacta en las tinieblas", 2, badConsequence, price) 
  
  #Los hondos
  badConsequence = BadConsequence.newDeath("Estos monstruos resultan bastante superciales y te aburren mortalmente. Estás muerto.")
  price = Prize.new(2,1)
  monsters << Monster.new("Los hondos", 8, badConsequence, price)
  
  #Semillas Cthulhu
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 4)
  price = Prize.new(2,1)
  monsters << Monster.new("Semillas Cthulhu", 4, badConsequence, price) 
  
  #Dameargo
  badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible.", 0, [TreasureKind::ONEHAND], Array.new)
  price = Prize.new(2,1)
  monsters << Monster.new("Dameargo", 1, badConsequence, price)
  
  #Pollipolipo volante
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0)
  price = Prize.new(1, 1)
  monsters << Monster.new("Pollipolipo volante", 3, badConsequence, price)
  
  #Yskhtihyssg-Goth
  badConsequence = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estás muerto.")
  price = Prize.new(3,1)
  monsters << Monster.new("Yskhtihyssg-Goth", 12, badConsequence, price)
  
  #Familia feliz
  badConsequence = BadConsequence.newDeath("La familia te atrapa. Estás muerto.")
  price = Prize.new(4,1)
  monsters << Monster.new("Familia feliz", 1, badConsequence, price)
  
  #Roboggoth
  badConsequence = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles.", 2, [TreasureKind::BOTHHAND], Array.new)
  price = Prize.new(2,1)
  monsters << Monster.new("Roboggoth", 8, badConsequence, price) 

  #El espia
  badConsequence = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible.", 0, [TreasureKind::HELMET], Array.new)
  price = Prize.new(1,1)
  monsters << Monster.new("El espia", 5, badConsequence, price)

  #El Lenguas
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0)
  price = Prize.new(1,1)
  monsters << Monster.new("El Lenguas", 20, badConsequence, price)

  #Bicefalo
  badConsequence = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, [TreasureKind::BOTHHAND], Array.new)
  price = Prize.new(1,1)
  monsters << Monster.new("Bicefalo", 20, badConsequence, price)
  
  #// ----------- FIN DE MONSTRUOS ----------- \\
 
  
  #// ----------- CONSULTAS ----------- \\  
  
#  Mostrar todos los monstruos.
#  
#  monsters.each { |i| puts i.to_s}
  
  #Mostrar todos los monstruos que tengan un nivel de combate superior a 10.
  puts "\n------- Monstruos que tienen un nivel de combate superior a 10. -------"  
  @cont = 0
  monsters.each { |i| 
    if (i.combatLevel > 10)
      puts i.to_s
      @cont = @cont + 1
    end        
  }
  puts "Numero de monstruos encontrados: #{@cont}"
  puts "------- FIN monstruos que tienen un nivel de combate superior a 10. ------- "
  
  #Mostrar todos los monstruos que tengan un mal rollo que implique sólo pérdida de niveles.
  puts "\n------- Monstruos que tienen un mal rollo que implique solo perdida de niveles. -------"
  @cont = 0
  monsters.each { |i| 
    if (i.bc.someLevels > 0 && i.bc.someVisibleTreasures == 0 && i.bc.someHiddenTreasures == 0 && i.bc.someSpecificVisibleTreasures.empty? && i.bc.someSpecificHiddenTreasures.empty?) 
      puts i.to_s
      @cont = @cont + 1
    end        
  } 
  puts "Numero de monstruos encontrados: #{@cont}"
  puts "------- FIN monstruos que tienen un mal rollo que implique solo perdida de niveles. -------"
  
  #Mostrar todos los monstruos que tengan un buen rollo que indique una ganancia de niveles superior a 1.
  puts "\n------- Monstruos que tienen un buen rollo que indique una ganancia de niveles superior a 1. ------- "
  @cont = 0
  monsters.each { |i| 
    if (i.price.level > 1)
      puts i.to_s
      @cont = @cont + 1
    end        
  } 
  puts "Numero de monstruos encontrados: #{@cont}"
  puts "------- FIN monstruos que tienen un buen rollo que indique una ganancia de niveles superior a 1. ------- "
  
  #Mostrar todos los monstruos que tengan un mal rollo que suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos
  puts "\n------- Monstruos que tienen un mal rollo que suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos. ------- "
  @cont = 0
  monsters.each { |i| 
    if (i.bc.someSpecificVisibleTreasures.empty? == false || i.bc.someSpecificHiddenTreasures == false)
      puts i.to_s
      @cont = @cont + 1
    end        
  } 
  puts "Numero de monstruos encontrados: #{@cont}"
  puts "------- FIN Monstruos que tienen un mal rollo que suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos. ------- "
  
  #// ----------- FIN DE CONSULTAS ----------- \\  
  
end
