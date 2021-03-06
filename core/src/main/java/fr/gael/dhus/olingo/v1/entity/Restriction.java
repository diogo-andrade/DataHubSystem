/*
 * Data Hub Service (DHuS) - For Space data distribution.
 * Copyright (C) 2013,2014,2015,2016 GAEL Systems
 *
 * This file is part of DHuS software sources.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.gael.dhus.olingo.v1.entity;

import fr.gael.dhus.database.object.restriction.AccessRestriction;
import fr.gael.dhus.olingo.v1.entityset.RestrictionEntitySet;
import org.apache.olingo.odata2.api.exception.ODataException;

import java.util.HashMap;
import java.util.Map;

public class Restriction extends V1Entity
{
   private AccessRestriction restriction;

   public Restriction (
         fr.gael.dhus.database.object.restriction.AccessRestriction restriction)
   {
      this.restriction = restriction;
   }

   @Override
   public Map<String, Object> toEntityResponse (String root_url)
   {
      Map<String, Object> response = new HashMap<> ();
      response.put (RestrictionEntitySet.ID, restriction.getId ());
      response.put (
            RestrictionEntitySet.REASON, restriction.getBlockingReason ());
      return response;
   }

   @Override
   public Object getProperty (String prop_name) throws ODataException
   {
      switch (prop_name)
      {
         case RestrictionEntitySet.ID:
            return restriction.getId ();

         case RestrictionEntitySet.REASON:
            return restriction.getBlockingReason ();

         default:
            throw new ODataException (
                  "Property '" + prop_name + "' not found.");
      }
   }
}
