package eu.crg.ega.microservice.dto.message;

import eu.crg.ega.microservice.dto.archive.File;
import eu.crg.ega.microservice.enums.ArchiveIdTypes;
import eu.crg.ega.microservice.enums.ArchiveSourceTypes;
import eu.crg.ega.microservice.enums.FileEventType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FileEventMessage extends EventMessage {

  private FileEventType fileEventSubtype;

  private ArchiveSourceTypes archiveSourceTypes;

  private ArchiveIdTypes archiveIdTypes;

  private File file;

}
