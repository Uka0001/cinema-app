package cinema.project.spring.controller;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import cinema.project.spring.dto.request.MovieSessionRequestDto;
import cinema.project.spring.dto.response.MovieSessionResponseDto;
import cinema.project.spring.model.MovieSession;
import cinema.project.spring.service.MovieSessionService;
import cinema.project.spring.service.mapper.RequestDtoMapper;
import cinema.project.spring.service.mapper.ResponseDtoMapper;
import cinema.project.spring.util.DateTimePatternUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final RequestDtoMapper<MovieSessionRequestDto, MovieSession>
            movieSessionRequestDtoMapper;
    private final ResponseDtoMapper<MovieSessionResponseDto, MovieSession>
            movieSessionResponseDtoMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
            RequestDtoMapper<MovieSessionRequestDto, MovieSession> movieSessionRequestDtoMapper,
            ResponseDtoMapper<MovieSessionResponseDto, MovieSession>
                                      movieSessionResponseDtoMapper) {
        this.movieSessionService = movieSessionService;
        this.movieSessionRequestDtoMapper = movieSessionRequestDtoMapper;
        this.movieSessionResponseDtoMapper = movieSessionResponseDtoMapper;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody @Valid MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionRequestDtoMapper.mapToModel(requestDto);
        movieSessionService.add(movieSession);
        return movieSessionResponseDtoMapper.mapToDto(movieSession);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> findAvailableSessions(@RequestParam Long movieId,
                                                @RequestParam
            @DateTimeFormat(pattern = DateTimePatternUtil.DATE_PATTERN)
                                                        LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(movieSessionResponseDtoMapper::mapToDto)
                .toList();
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody @Valid MovieSessionRequestDto requestDto) {
        MovieSession movieSession = movieSessionRequestDtoMapper.mapToModel(requestDto);
        movieSession.setId(id);
        movieSessionService.update(movieSession);
        return movieSessionResponseDtoMapper.mapToDto(movieSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieSessionService.delete(id);
    }
}
