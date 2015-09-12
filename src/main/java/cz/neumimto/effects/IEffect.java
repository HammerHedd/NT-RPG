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

package cz.neumimto.effects;

import cz.neumimto.GlobalScope;
import cz.neumimto.NtRpgPlugin;

import java.util.UUID;

/**
 * Created by NeumimTo on 17.1.2015.
 */
public interface IEffect {
    String getName();

    void onApply();

    void onStack(int level);

    void onRemove();

    int getLevel();

    void setLevel(int level);

    boolean isStackable();

    boolean setStackable(boolean b);

    boolean requiresRegister();

    EffectSource getEffectSource();

    void setEffectSource(EffectSource effectSource);

    long getPeriod();

    void setPeriod(long period);

    long getLastTickTime();

    void setLastTickTime(long currTime);

    void onTick();

    long getExpireTime();

    long getTimeLeft(long currenttime);

    long getDuration();

    void setDuration(long l);

    void tickCountIncrement();

    UUID getUUID();

    String getExpireMessage();

    void setExpireMessage(String expireMessage);

    String getApplyMessage();

    void setApplyMessage(String applyMessage);

    void setConsumer(IEffectConsumer consumer);

    IEffectConsumer getConsumer();

    static GlobalScope getGlobalScope() {
        return NtRpgPlugin.GlobalScope;
    }

}
