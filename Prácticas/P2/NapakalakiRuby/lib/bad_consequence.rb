#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative 'treasure_kind'

module Napakalaki
  
  class BadConsequence
    
  attr_accessor :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures, :death
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
    @death = death    
  end
  
  def self.newLevelNumberOfTreasures (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    # asigna memoria para el objeto
    nuevoObj=allocate      
    # inicializa el objeto, invocando al método initialize
    nuevoObj.send(:initialize,aText, someLevels, someVisibleTreasures, someHiddenTreasures, Array.new, Array.new, false)     
    #devuelve el objeto creado e inicializado
    nuevoObj 
  end
  
  def self.newLevelSpecificTreasures (aText, someLevels,someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    nuevoObj=allocate      
    nuevoObj.send(:initialize,aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)     
    nuevoObj 
  end
  
  def self.newDeath (aText)
    nuevoObj=allocate      
    nuevoObj.send(:initialize,aText, 0, 0, 0, Array.new, Array.new, true)     
    nuevoObj
  end

  private_class_method :new  
  
  def to_s
    cadena = " \n\t\tText = #{@text} \n\t\tLevel = #{@levels} \n\t\tSomeVisibleTreasures = #{@nVisibleTreasures} \n\t\tSomeHiddenTreasures = #{@nHiddenTreasures} \n\t\tDeath = #{@death}"
    specificVisibleTreasures.each { |t| cadena +=  " \n\t\tSomeSpecificVisibleTreasures = #{t}"  }
    specificHiddenTreasures.each { |t| cadena +=  " \n\t\tSomeSpecificHiddenTreasures = #{t}"  }
    return cadena       
  end 
  
  def substractVisibleTreasure( t )
  
  end 
    
  def substractHiddenTreasure( t )
  
  end    
  
  # Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
  # significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
  # cumplir, plantéate qué valores deberán tener.  
  def isEmpty
    if @levels == 0 && @nHiddenTreasures == 0 && @nVisibleTreasures == 0 && @specificHiddenTreasures.empty? && @specificVisibleTreasures.empty? && @death == false 
            return true
    else
            return false
    end
  end
    
  def adjustToFitTreasureLists( v, h )
  
  end
  
  # Devuelve true si es un mal rollo es muerte, false en caso contrario.
  def myBadConsequencesIsDeath
    return @death
  end
  
  end
end

