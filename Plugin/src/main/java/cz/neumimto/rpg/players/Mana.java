/*    
 *     Copyright (c) 2015, NeumimTo https://github.com/NeumimTo
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *     
 */

package cz.neumimto.rpg.players;

import cz.neumimto.rpg.players.properties.DefaultProperties;

/**
 * Created by NeumimTo on 30.12.2014.
 */
public class Mana implements IReservable {
    private final IActiveCharacter activeCharacter;

    public Mana(IActiveCharacter activeCharacter) {
        this.activeCharacter = activeCharacter;
    }

    @Override
    public double getMaxValue() {
        return activeCharacter.getCharacterProperty(DefaultProperties.max_mana);
    }

    @Override
    public void setMaxValue(double f) {
        activeCharacter.setCharacterProperty(DefaultProperties.max_mana, (float) f);
    }

    @Override
    public void setReservedAmnout(float f) {
        activeCharacter.setCharacterProperty(DefaultProperties.reserved_mana, f);
    }

    @Override
    public double getReservedAmount() {
        return activeCharacter.getCharacterProperty(DefaultProperties.reserved_mana);
    }

    @Override
    public double getValue() {
        return activeCharacter.getCharacterProperty(DefaultProperties.mana);
    }

    @Override
    public void setValue(double f) {
        if (activeCharacter.getMana().getMaxValue() < f)
            f = activeCharacter.getMana().getMaxValue();
        activeCharacter.setCharacterProperty(DefaultProperties.mana, (float) f);
    }

    @Override
    public double getRegen() {
        return activeCharacter.getCharacterProperty(DefaultProperties.mana_regen);
    }

    @Override
    public void setRegen(float f) {
        activeCharacter.setCharacterProperty(DefaultProperties.mana_regen, f);
    }
}
