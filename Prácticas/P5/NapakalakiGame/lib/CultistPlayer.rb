# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'Treasure'
require_relative 'Monster'
require_relative 'Treasurekind'
require_relative 'CombatResult'
require_relative 'Dice'
require_relative 'Napakalaki'
require_relative 'Player'

module NapakalakiGame
class CultistPlayer < Player  
  attr_accessor :myCultistCard    
  #Atributo de Clase
  @@totalCultistPlayers = 0
  def initialize(player, cultist)
    super(player.name)
    copyConstructor(player)
    @myCultistCard = cultist
    @@totalCultistPlayers += 1 #Incrementamos el contador de cultistPlayers
  end  
  #Métodos
  def getCombatLevel
    #En ruby super es una llamada al metodo padre, asi que lo asignamos
    #a una variable y le sumamos el specialValue
    cl = super      
    cl += @myCultistCard.getSpecialValue
    return cl
  end
  def shouldConvert
    #Siempre devuelve false
    return false
  end
  def getOponentLevel(monster) 
    return monster.getSpecialValue
  end
  def computeGoldCoinsValue(treasures)      
    #Devolvemos el valor
    return super.computeGoldCoinsValue(treasures) * 2
  end
  #Metodo de la clase
  def self.totalCultistPlayers
    return @@totalCultistPlayers
  end        
end
end
