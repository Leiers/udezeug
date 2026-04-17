export type CourseBadge =
  "OFFICIAL" |
  "POPULAR"

export const badgeConfig = {
  "OFFICIAL": {color: 'oklch(69.6% 0.17 162.48)', icon: 'check'},
  "POPULAR": {color: 'oklch(87.9% 0.169 91.605)', icon: 'star'}
} satisfies Record<CourseBadge, BadgeStyle>

interface BadgeStyle {
  color: string,
  icon: string
}
