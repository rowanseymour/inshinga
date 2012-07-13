################################################################
#
# SQL script to extract verb list from a Kumva database
#
# Copyright 2011 Rowan Seymour
#
# This file is part of Inshinga.
#
# Inshinga is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# Inshinga is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with Inshinga. If not, see <http://www.gnu.org/licenses/>.
#

SELECT r.lemma as `stem`, r.modifier, GROUP_CONCAT(t.text SEPARATOR ',') as `meanings`
FROM rw_revision r
INNER JOIN rw_revision_tag rt ON rt.revision_id = r.revision_id AND rt.relationship_id = 3
INNER JOIN rw_tag t ON t.tag_id = rt.tag_id
WHERE status = 1 AND wordclass = 'v'
GROUP BY r.entry_id
ORDER BY r.lemma, r.modifier
LIMIT 0, 999999;