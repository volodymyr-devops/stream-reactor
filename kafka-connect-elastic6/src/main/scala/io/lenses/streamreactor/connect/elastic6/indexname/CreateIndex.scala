/*
 * Copyright 2017-2024 Lenses.io Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lenses.streamreactor.connect.elastic6.indexname

import io.lenses.kcql.Kcql

/**
  * Creates the index for the given KCQL configuration.
  */
object CreateIndex {
  def getIndexName(kcql: Kcql): String =
    Option(kcql.getIndexSuffix).fold(kcql.getTarget) { indexNameSuffix =>
      s"${kcql.getTarget}${CustomIndexName.parseIndexName(indexNameSuffix)}"
    }
}
