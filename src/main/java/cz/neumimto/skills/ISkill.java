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

package cz.neumimto.skills;

import cz.neumimto.players.IActiveCharacter;
import org.spongepowered.api.event.cause.entity.damage.DamageType;

import java.net.URL;
import java.util.Set;

/**
 * Created by NeumimTo on 1.1.2015.
 */
public interface ISkill {

    String getName();

    void init();

    void setName(String name);

    void skillLearn(IActiveCharacter character);

    void skillUpgrade(IActiveCharacter character, int level);

    void skillRefund(IActiveCharacter character);

    SkillSettings getDefaultSkillSettings();

    void onCharacterInit(IActiveCharacter c, int level);

    SkillResult onPreUse(IActiveCharacter character);

    Set<SkillType> getSkillTypes();

    SkillSettings getSettings();

    void setSettings(SkillSettings settings);

    String getDescription();

    String getLore();

    void setDescription(String description);

    boolean showsToPlayers();

    SkillItemIcon getIcon();

    URL getIconURL();

    void setIconURL(URL url);

    DamageType getDamageType();

    void setDamageType(DamageType type);
}
