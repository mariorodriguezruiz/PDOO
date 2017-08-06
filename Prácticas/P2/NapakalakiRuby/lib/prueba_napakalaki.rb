#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'prize.rb'
require_relative 'monster.rb'
require_relative 'bad_consequence.rb'
require_relative 'treasure_kind.rb'

class PruebaNapakalaki
    
  #// ----------- CONSULTAS ----------- \\  
  
#  Mostrar todos los monstruos.
#  
#  monsters.each { |i| puts i.to_s}
  
#  Mostrar todos los monstruos que tengan un nivel de combate superior a 10.
#  puts "\n------- Monstruos que tienen un nivel de combate superior a 10. -------"  
#  @cont = 0
#  monsters.each { |i| 
#    if (i.combatLevel > 10)
#      puts i.to_s
#      @cont = @cont + 1
#    end        
#  }
#  puts "Numero de monstruos encontrados: #{@cont}"
#  puts "------- FIN monstruos que tienen un nivel de combate superior a 10. ------- "
#  
#  Mostrar todos los monstruos que tengan un mal rollo que implique sólo pérdida de niveles.
#  puts "\n------- Monstruos que tienen un mal rollo que implique solo perdida de niveles. -------"
#  @cont = 0
#  monsters.each { |i| 
#    if (i.bc.levels > 0 && i.bc.nVisibleTreasures == 0 && i.bc.nHiddenTreasures == 0 && i.bc.specificVisibleTreasures.empty? && i.bc.specificHiddenTreasures.empty?) 
#      puts i.to_s
#      @cont = @cont + 1
#    end        
#  } 
#  puts "Numero de monstruos encontrados: #{@cont}"
#  puts "------- FIN monstruos que tienen un mal rollo que implique solo perdida de niveles. -------"
#  
#  Mostrar todos los monstruos que tengan un buen rollo que indique una ganancia de niveles superior a 1.
#  puts "\n------- Monstruos que tienen un buen rollo que indique una ganancia de niveles superior a 1. ------- "
#  @cont = 0
#  monsters.each { |i| 
#    if (i.price.level > 1)
#      puts i.to_s
#      @cont = @cont + 1
#    end        
#  } 
#  puts "Numero de monstruos encontrados: #{@cont}"
#  puts "------- FIN monstruos que tienen un buen rollo que indique una ganancia de niveles superior a 1. ------- "
#  
#  Mostrar todos los monstruos que tengan un mal rollo que suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos
#  puts "\n------- Monstruos que tienen un mal rollo que suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos. ------- "
#  @cont = 0
#  monsters.each { |i| 
#    if (i.bc.specificVisibleTreasures.empty? == false || i.bc.specificHiddenTreasures == false)
#      puts i.to_s
#      @cont = @cont + 1
#    end        
#  } 
#  puts "Numero de monstruos encontrados: #{@cont}"
#  puts "------- FIN Monstruos que tienen un mal rollo que suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos. ------- "
#  
#  #// ----------- FIN DE CONSULTAS ----------- \\  
  
end
