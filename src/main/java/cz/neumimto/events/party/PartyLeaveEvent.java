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

package cz.neumimto.events.party;

import cz.neumimto.events.CancellableEvent;
import cz.neumimto.players.IActiveCharacter;
import cz.neumimto.players.parties.Party;

/**
 * Created by ja on 2.9.2015.
 */
public class PartyLeaveEvent extends CancellableEvent {
    private Party party;
    private IActiveCharacter leaver;

    public PartyLeaveEvent(Party party, IActiveCharacter leaver) {
        this.party = party;
        this.leaver = leaver;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public IActiveCharacter getLeaver() {
        return leaver;
    }

    public void setLeaver(IActiveCharacter leaver) {
        this.leaver = leaver;
    }
}
