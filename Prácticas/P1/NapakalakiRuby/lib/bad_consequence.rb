#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence
  
  attr_accessor :aText, :someLevels, :someVisibleTreasures, :someHiddenTreasures, :someSpecificVisibleTreasures, :someSpecificHiddenTreasures, :death
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @aText = aText
    @someLevels = someLevels
    @someVisibleTreasures = someVisibleTreasures
    @someHiddenTreasures = someHiddenTreasures
    @someSpecificVisibleTreasures = someSpecificVisibleTreasures
    @someSpecificHiddenTreasures = someSpecificHiddenTreasures
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
    cadena = " \n\t\tText = #{@aText} \n\t\tLevel = #{@someLevels} \n\t\tSomeVisibleTreasures = #{@someVisibleTreasures} \n\t\tSomeHiddenTreasures = #{@someLevels} \n\t\tDeath = #{@death}"
    someSpecificVisibleTreasures.each { |t| cadena +=  " \n\t\tSomeSpecificVisibleTreasures = #{t}"  }
    someSpecificHiddenTreasures.each { |t| cadena +=  " \n\t\tSomeSpecificHiddenTreasures = #{t}"  }
    return cadena       
  end     
  
end
