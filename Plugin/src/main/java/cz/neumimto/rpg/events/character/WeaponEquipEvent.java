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

package cz.neumimto.rpg.events.character;

import cz.neumimto.rpg.events.CancellableEvent;
import cz.neumimto.rpg.inventory.Weapon;
import cz.neumimto.rpg.players.IActiveCharacter;

/**
 * Created by NeumimTo on 12.2.2015.
 */
public class WeaponEquipEvent extends CancellableEvent {
    final IActiveCharacter player;
    final Weapon newItem;
    final Weapon lastItem;

    public WeaponEquipEvent(IActiveCharacter player, Weapon newItem, Weapon currentWeapon) {
        this.player = player;
        this.newItem = newItem;
        this.lastItem = currentWeapon;
    }

    public IActiveCharacter getPlayer() {
        return player;
    }

    public Weapon getNewItem() {
        return newItem;
    }

    public Weapon getLastItem() {
        return lastItem;
    }

}
